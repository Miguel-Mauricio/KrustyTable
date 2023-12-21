$(function(){
    //get();

    getFoodValues();

     var info= undefined;
     $("#btn-takeaway").click(function(){
     var date=new Date();
         alert("Let's prepare your food");
         post();
         get();
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