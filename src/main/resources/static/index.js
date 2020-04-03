$(document).ready(function () {
  $('#sum').click(() => {
    var a = $('#a').val()
    var b = $('#b').val()
    $.get("/api/v1/math/sum/" + a + "&" + b, data => {
      $("#result").html(a + " + " + b + " -> " + data);
    });
  });
  $('#substrac').click(() => {
    var a = $('#a').val()
    var b = $('#b').val()
    $.get("/api/v1/math/substrac/" + a + "&" + b, data => {
      $("#result").html(a + " - " + b + " -> " + data);
    });
  });
  $('#multiply').click(() => {
    var a = $('#a').val()
    var b = $('#b').val()
    $.get("/api/v1/math/multiply/" + a + "&" + b, data => {
      $("#result").html(a + " * " + b + " -> " + data);
    });
  });
  $('#divide').click(() => {
    var a = $('#a').val()
    var b = $('#b').val()
    $.get("/api/v1/math/divide/" + a + "&" + b, data => {
      $("#result").html(a + " / " + b + " -> " + data);
    });
  });
  $('#square').click(() => {
    var a = $('#a').val()
    var b = $('#b').val()
    $.get("/api/v1/math/square/" + a, data => {
      $("#result").html(a + " ^ 2 -> " + data);
    });
    $.get("/api/v1/math/square/" + b, data => {
      $("#result").html($("#result").html() + " and " + a + " ^ 2 -> " + data);
    });
  });
  $('#exponent').click(() => {
    var a = $('#a').val()
    var b = $('#b').val()
    $.get("/api/v1/math/exponent/" + a + "&" + b, data => {
      $("#result").html(a + " ^ " + b + " -> " + data);
    });
  });
});