<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p>to</p>
<input type="text" id="to">
<p>subject</p>
<input type="text" id="subject">
<p>text</p>
<input type="text" id="text">
<p>from</p>
<input type="text" id="from">
<button id="submitBtn">Submit</button>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>

$("#submitBtn").click(function (){
    let to = $("#to").val();
    let subject = $("#subject").val();
    let text = $("#text").val();
    let from = $("#from").val();

    let data = {
        to,subject,text,from
    }

    $.ajax({
        url: "/api/edm1Test",
        type: "POST",
        data,
        success(data) {
            console.log(data)
        }
    })

})

</script>
</body>
</html>