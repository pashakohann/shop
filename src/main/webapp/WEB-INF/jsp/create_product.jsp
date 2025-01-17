<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value = "${not empty sessionScope.language ? sessionScope.language : 'en'}"/>
<fmt:setBundle basename = "locale" var="loc"/>

<fmt:message bundle="${loc}" key = "copyRight" var="copyRight"/>
<fmt:message bundle="${loc}" key = "computerShop" var="computerShop"/>
<fmt:message bundle="${loc}" key = "russian" var="russian"/>
<fmt:message bundle="${loc}" key = "english" var="english"/>
<fmt:message bundle="${loc}" key = "backToMenu" var="backToMenu"/>
<fmt:message bundle="${loc}" key = "allUsers" var="allUsers"/>
<fmt:message bundle="${loc}" key = "allUserProfiles" var="allUserProfiles"/>
<fmt:message bundle="${loc}" key = "allOrders" var="allOrders"/>
<fmt:message bundle="${loc}" key = "allProductss" var="allProductss"/>
<fmt:message bundle="${loc}" key = "addProduct" var="addProduct"/>
<fmt:message bundle="${loc}" key = "yourProfile" var="yourProfile"/>
<fmt:message bundle="${loc}" key = "yourWallet" var="yourWallet"/>
<fmt:message bundle="${loc}" key = "backToMenu" var="backToMenu"/>
<fmt:message bundle="${loc}" key = "add" var="add"/>
<fmt:message bundle="${loc}" key = "delete" var="delete"/>
<fmt:message bundle="${loc}" key = "motherBoard" var="motherBoard"/>
<fmt:message bundle="${loc}" key = "ram" var="ram"/>
<fmt:message bundle="${loc}" key = "powerUnit" var="powerUnit"/>
<fmt:message bundle="${loc}" key = "hdd" var="hdd"/>
<fmt:message bundle="${loc}" key = "cpu" var="cpu"/>
<fmt:message bundle="${loc}" key = "cooler" var="cooler"/>
<fmt:message bundle="${loc}" key = "gpu" var="gpu"/>
<fmt:message bundle="${loc}" key = "casee" var="casee"/>
<fmt:message bundle="${loc}" key = "name" var="name"/>
<fmt:message bundle="${loc}" key = "cost" var="cost"/>
<fmt:message bundle="${loc}" key = "brand" var="brand"/>
<fmt:message bundle="${loc}" key = "category" var="category"/>
<fmt:message bundle="${loc}" key = "photoLink" var="photoLink"/>
<fmt:message bundle="${loc}" key = "action" var="action"/>



<!DOCTYPE html>
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <link rel="stylesheet" href="css/style_basket.css">
   <title>All users</title>

</head>
<body >
 <div class="container">

   <div class="d-grid gap-2 d-md-flex justify-content-md-end">

      <button class="btn btn-primary me-md-2" type="button"><a href="${pageContext.request.contextPath}/shop?command=back_action_command" style="color:white;">${backToMenu}</a></button>

    </div>
    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
      <ol class="breadcrumb">
         <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_panel_command">${allUsers}</a></li>
         <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_accounts_command">${allUserProfiles}</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_orders_command">${allOrders}</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_products_command">${allProductss}</a></li>
        <li class="breadcrumb-item active" aria-current="page">${addProduct}</li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_profile_command">${yourProfile}</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_wallet_command">${yourWallet}</a></li>


      </ol>
    </nav>
   </header>
   <table class="table table-dark table-striped" >
      <table class="table">
         <thead>
          <c:choose>
                        <c:when test="${not empty error}">
                        <p style="color: red;">${error}</p>
                        </c:when>

                         <c:when test="${not empty message}">
                                <p style="color: red;">${message}</p>
                         </c:when>
                          </c:choose>
           <tr>

             <th scope="col">${name}</th>
             <th scope="col">${cost}</th>
             <th scope="col">${category}</th>
             <th scope="col">${brand}</th>
             <th scope="col">${photoLink}</th>
             <th scope="col">${action}</th>
           </tr>
         </thead>
         <tbody>


    <form class="form-horizontal" action="${pageContext.request.contextPath}/shop?command=add_product_command" method="post">
             <td><input class="form-control" type="name" name="name" id="name" placeholder="${password}"   title="${validationPassword}">
              <p class="help-block"> </p></td>
             <td ><input class="form-control" type="cost" name="cost" id="cost" placeholder="${password}"   title="${validationPassword}">
              <p class="help-block"> </p></td>
             <td >
              <select class="form-select"  name="category"aria-label="Default select example">

                <option value="1">${motherBoard}</option>
                <option value="2">${ram}</option>
                <option value="3">${powerUnit}</option>
                <option value="4">${hdd}</option>
                <option value="5">${cpu}</option>
                <option value="6">${casee}</option>
                <option value="7">${cooler}</option>
                <option value="8">${gpu}</option>

              </select>
             </td>
             <td >
              <select class="form-select"  name="brand" aria-label="Default select example">

                <option value="1">ASRock</option>
                <option value="2">Gigabyte</option>
                <option value="3">ASUS</option>
                <option value="4">BIOSTAR</option>
                <option value="5">MSI</option>
                <option value="6">Crucial</option>
                <option value="7">Kingston</option>
                <option value="8">Chieftec</option>
                <option value="9">AeroCool</option>
                <option value="10">WD</option>
                <option value="11">Seagate</option>
                <option value="12">AMD</option>
                <option value="13">Intel</option>
                <option value="14">Zalman</option>
                <option value="15">DeepCool</option>

              </select>
             </td>
             <td ><input class="form-control" type="name" name="photoLink" id="photoLink" placeholder="your link"   title="${validationPassword}">
              <p class="help-block"> </p></td>
               <td> <button submit="button" class="button" style="color:white;background-color: rebeccapurple;">${add}</button></td>
           </tr>

         </tbody>
       </table>
    </table>
 </div>
  <!-- Дополнительный JavaScript; выберите один из двух! -->

    <!-- Вариант 1: Bootstrap в связке с Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Вариант 2: Bootstrap JS отдельно от Popper
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->

<footer class="page-footer font-small blue pt-4" style="position: fixed;left: 0; bottom: 0;padding: 15px;background: #c4c2c7; color: #fff;  width: 100%; height: 5%;">

   <div class="container-fluid text-center text-md-left">

     <div class="row">

       <div class="col-md-6 mt-md-0 mt-3">


         <h5 class="text-uppercase" style="padding-bottom: 12px;">${computerShop}</h5>

       </div>

       <hr class="clearfix w-100 d-md-none pb-3">

       <div class="dropdown">
         <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" style="margin-left: 1300px; margin-top:-110px; height: 45px; width: 65px;">
          <img src="/img/img_language.jpg" style="width: 45px; height: 45px; padding-top: 1px; padding-bottom: 17px; padding-right: 6px; " alt="">
         </button>
         <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
         <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=language_command&language=en">${english}</a></li>
           <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=language_command&language=ru">${russian}</a></li>


         </ul>
       </div>

     </div>

   </div>

   <div class="footer-copyright text-center py-3 " style="margin-top:-105px;">© 2021 ${copyRight}:
     <a href="https://github.com/pashakohann/Shop"><img src="/img/png-github-logo.png" alt=""  style="height: 40px; width: 70px; "></a>
   </div>
 </footer>
</body>
</html>