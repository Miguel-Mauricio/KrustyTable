$(function(){
    //get();

    getFoodValues();


    $("#btn-takeaway").click(function(){
      var date=new Date();
          alert("Let's prepare your food");
          post();
          get();
        });

     var info= undefined;


     $("#btn-get-takeaway").click(function(){
        getOrderDetails( $("#orderId").val() );
       });

       function successCallback(response) {

         if(response.id){
          alert(`Your order was made sucessfully!
              Order #${response.id}
          `)
         }
       }
       function errorCallback(request, status, error) {
         alert("something went wrong with preparing your order...")
       }
       function createRequest(){
         return {
             firstName : $('#fname2').val(),
             lastName : $('#lname2').val(),
             email : $('#email2').val(),
             phone : $('#phone2').val(),
             food:
             {
                 id: parseInt($("#food-choice").val())
             }
         }
       }

       function post(){
         console.log("Executing");
         $.ajax({
           url: 'http://localhost:8080/took-away/api/order/',
           type: 'POST',
            data: JSON.stringify(
               createRequest()
           ),
           async: true,
           contentType: 'application/json',
           success: successCallback,
           error: errorCallback,
         });



         console.log("Executing");
       }
    function get(data){
        console.log("batata")
     $.get('http://localhost:8080/took-away/api/order/',function(data){
         console.log(JSON.stringify(data))
     })
 }
    });


   async function getFoodValues(){

       var response = await fetch("http://localhost:8080/took-away/api/food/");
       var foods = await response.json();

       var options = "";
       foods.forEach(element => {
           options += `<option value="${element.id}">${element.name}</option>`;
       });

       $("#food-choice").append(options);


    }

    async function getOrderDetails(orderId){

      $("#getResponse").empty();

      var response = await fetch(`http://localhost:8080/took-away/api/order/${orderId}`);
      var element = await response.json();

      var text = `
      <div class="card" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">Order Number: ${element.id}</h5>
        <h6 class="card-subtitle mb-2 text-muted">Order Details:</h6>
        <p class="card-text">${element.firstName} ${element.lastName}</p>
        <p class="card-text">What you ordered:</p>
        <p class="card-text">${element.food.name}</p>
        <p class="card-text">Price: ${element.food.price}</p>
        <p class="card-text">Food Id: ${element.food.id}</p>
      </div>
    </div>
    `
      

      $("#getResponse").append(text);


   }