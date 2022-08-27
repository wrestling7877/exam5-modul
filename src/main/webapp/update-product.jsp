<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>ADD NEW BOOK</title>


    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">

    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>


</head>
<body>
<h1>Update PRODUCT</h1>
<br/>

<div class="row">
    <div class="col-md-6 offset-3">


        <form action="/update-product" method="post" enctype="multipart/form-data">

            <div class="form-group">
                <label for="name">Name:</label>
                <input
                        id="name"
                        type="text"
                        name="name"
                        value="${product.getName()}"
                        class="form-control"
                        placeholder="Input title..."
                >
            </div>
            <div class="form-group">
                <label for="id"></label>
                <input
                        id="id"
                        type="text"
                        name="id"
                        hidden
                        value="${product.getId()}"
                        class="form-control"
                        placeholder="Input title..."
                >
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input class="form-control"   value="${product.getDescription()}" rows="3" id="description"  name="description">

                <div class="form-group">
                    <label for="categoryId">Category:</label>
                    <select required class="form-control" id="categoryId" name="categoryId">
                        <option selected disabled value="">Select category: </option>

                        <c:forEach items="${categoryList}" var="category" >
                            <option  value="${category.getId()}">${category.getName()} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="salary">Salary:</label>
                    <input class="form-control" id="salary"   value="${product.getSalary()}"  type=number name="salary">
                </div>

                <div class="form-group">
                    <label for="image">Upload cover image:</label>

                    <input class="form-control-file" id="image"  type="file" name="image">

                    <input   value="${product.getImgUrl()}"  type="text"  name="url">

                </div>

                <button type="submit" class="btn btn-primary">Save</button>

        </form>

    </div>
</div>

<script>

    $(document).ready(function () {
        $('#framework').multiselect({
            nonSelectedText: 'Select Framework',
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            buttonWidth: '400px'
        });
    });
</script>

</body>
</html>