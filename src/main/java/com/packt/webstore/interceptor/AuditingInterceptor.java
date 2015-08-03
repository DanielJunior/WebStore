/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.interceptor;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author danieljr
 */
public class AuditingInterceptor extends HandlerInterceptorAdapter {

    Logger logger = Logger.getLogger("auditLogger");
    private String user;
    private String productId;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler) throws Exception {
        if (request.getRequestURI().endsWith("products/add")
                && request.getMethod().equals("POST")) {
            user = request.getRemoteUser();
            productId = request.getParameterValues("productId")[0];
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                    Object handler, Exception arg3) throws Exception {
        if (request.getRequestURI().endsWith("products/add")
                && response.getStatus() == 302) {
            logger.info(String.format("A	New	product[%s]	Added	by	%son	%s",
                    productId, user, getCurrentTime()));
        }
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy	'at'hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
