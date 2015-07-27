<%-- 
    Document   : addProduct
    Created on : 27/07/2015, 14:06:23
    Author     : danieljr
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Products</title
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <a href="<c:url	value="/j_spring_security_logout" />"	class="btn btn-danger btn-mini pull-right">logout</a>		
                <div class="container">
                    <h1>Products</h1>
                    <p>Add products</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newProduct" class="form-horizontal">
                <fieldset>
                    <legend>Add	new product</legend>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                            <spring:message code="addProduct.form.productId.label"/>
                        </label>
                        <div class="col-lg-10">
                            <form:input	id="productId"	path="productId" type="text" class="form:input-large"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
                        <div class="col-lg-10">
                            <form:input	id="name" path="name" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <!--	Similarly	bind	<--form:input>	tag	for	
name,unitPrice,manufacturer,category,unitsInStock	and	unitsInOrder	
fields-->
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="description">Description</label>
                        <div class="col-lg-10">
                            <form:textarea id="description" path="description" rows="2"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="unitPrice">Price</label>
                        <div class="col-lg-10">
                            <form:input id="unitPrice" path="unitPrice" type="number" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="unitsInStock">Units in stock</label>
                        <div class="col-lg-10">
                            <form:input id="unitsInStock" path="unitsInStock" type="number" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
                        <div class="col-lg-10">
                            <form:input id="manufacturer" path="manufacturer" type="text" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="category">Category</label>
                        <div class="col-lg-10">
                            <form:input id="category" path="category" type="text" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="condition">Condition</label>
                        <div class="col-lg-10">
                            <form:radiobutton path="condition"	value="New"/> New	
                            <form:radiobutton path="condition"	value="Old"/> Old	
                            <form:radiobutton path="condition"	value="Refurbished"/> Refurbished
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn	btn-primary" value="Add"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>
