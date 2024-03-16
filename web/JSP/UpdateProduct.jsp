<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update Product</title>
    </head>
    <body>
        <%
            Product pro=
                 (Product)request.getAttribute("pro");
        %>
       <form action="ProductController" method="post">
        <table>
            <tr>
                <tr>
                    <th>Product ID</th><td><input type="text" name="pid" 
                                                  value="<%=pro.getProductId()%>"></td>
                </tr><tr>   <th>product_name</th><td><input type="text" name="pname" 
                                                    value="<%=pro.getProductName()%>"></td>
                  </tr><tr>     <th>model_year</th><td><input type="text" name="model" 
                                                  value="<%=pro.getModelYear()%>"></td>
                  </tr><tr>     <th>list_price</th><td><input type="number" name="price"
                                                  value="<%=pro.getListPrice()%>"></td>
                  </tr><tr>     <th>brand_name</th><td><input type="text" name="brand" 
                                                  value="<%=pro.getBrandName()%>"></td>
                   </tr><tr>    <th>category_name</th><td><input type="text" name="cate" 
                                                     value="<%=pro.getCategoryName()%>"></td>
                   </tr><tr>   <th><input type="submit" value="update" name="submit"></th>
                    <th><input type="reset" value="reset">
                        <input type="hidden" name="service" value="update">
                               
                    </th>
                </tr>
            </tr>
        </table>

    </form>
    </body>
</html>
