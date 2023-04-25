<%-- 
    Document   : DisplayItem
    Created on : Apr 9, 2023, 9:30:42 AM
    Author     : Shalon
--%>
<jsp:include page="menu.jsp"/>
<html>
    <head>
        
    </head>
    <script type="text/javascript">
    $(document).ready(function(){
        console.log("started");
        $.ajax({
            type: "get",
            url: "../GetAllItem",
            data: null,
            beforeSend: function(){},
            success: function(data,status){
                $("#table").html(data);
            },
            error:function(xhr,data,status){}
        });
});
   
</script>
<body>
   
    <div class="main-content">
            <div class="title">Display Item</div>
            <div class="content">
                 
     <div id="table" class="display_table">
        
    </div>
      
            </div>
        </div>
</body>
   
</html>