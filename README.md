<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>

<p>Using a web browser, the user visits a site with the intention of completing a flashcard quiz.  (Currently localhost).</p>

<p>The user presses a button to start a quiz.  This begins the prompting of quiz questions. Pressing Enter or the Submit button causes the server to evaluate the question through JSON/Ajax. </p> 

<p>The server runs a program that simulates a quiz, it has no data storage, and all data is hardcoded.  This release doesn't evaluate the questions and answers correctly, it just fakes it, and produces a hardwired correct/incorrect response</p>.

<p>Quiz shows 5 questions, when done, allows the user to restart the quiz.</p> 

<p>This all takes place on a single HTML page, all interactions dynamically update the HTML and, and submit triggers AJAX.</p>

<h3>A run in the browser:</h3>

  <pre>
Let's do a quiz
Welcome!
[1] aqt: taq
wrong
[2] acr: car
correct
[3] bgo: obg
wrong
[4] cow: cow
correct
All done. Bye!
  </pre>


<h3>Requests sent from browser/ JSON returned from server</h3>

<div style="margin-top: 50px;">
<pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&response=&command=start
{"nextQuestionNumber":1,"questionsRemaining":3,"nextQuestion":"aqt","serverString":"Welcome!","guessResponse":"false"}
</pre>
</div>

<table><tbody><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;"><strong>Name</strong></td><td style="padding: 10px;"><strong>Value</strong></td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">type</td><td style="padding: 10px;">json</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">app</td><td style="padding: 10px;">quiz</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">response</td><td style="padding: 10px;"></td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">command</td><td style="padding: 10px;">start</td></tr></tbody></table>

<table><tbody><tr><td><div class="td_head">nextQuestionNumber</div></td><td><div class="td_row_even">1</div></td></tr><tr><td><div class="td_head">questionsRemaining</div></td><td><div class="td_row_even">3</div></td></tr><tr><td><div class="td_head">nextQuestion</div></td><td><div class="td_row_even">aqt</div></td></tr><tr><td><div class="td_head">serverString</div></td><td><div class="td_row_even">Welcome!</div></td></tr><tr><td><div class="td_head">guessResponse</div></td><td><div class="td_row_even">false</div></td></tr></tbody></table>


<div style="margin-top: 50px;">





<pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&response=taq&command=guess
{"nextQuestionNumber":2,"questionsRemaining":2,"nextQuestion":"acr","serverString":"wrong","guessResponse":"true"}
</pre>






</div>

<table><tbody><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;"><strong>Name</strong></td><td style="padding: 10px;"><strong>Value</strong></td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">type</td><td style="padding: 10px;">json</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">app</td><td style="padding: 10px;">quiz</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">response</td><td style="padding: 10px;">taq</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">command</td><td style="padding: 10px;">guess</td></tr></tbody></table>

<table><tbody><tr><td><div class="td_head">nextQuestionNumber</div></td><td><div class="td_row_even">2</div></td></tr><tr><td><div class="td_head">questionsRemaining</div></td><td><div class="td_row_even">2</div></td></tr><tr><td><div class="td_head">nextQuestion</div></td><td><div class="td_row_even">acr</div></td></tr><tr><td><div class="td_head">serverString</div></td><td><div class="td_row_even">wrong</div></td></tr><tr><td><div class="td_head">guessResponse</div></td><td><div class="td_row_even">true</div></td></tr></tbody></table>


<div style="margin-top: 50px;">





<pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&response=car&command=guess
{"nextQuestionNumber":3,"questionsRemaining":1,"nextQuestion":"bgo","serverString":"correct","guessResponse":"true"}
</pre>






</div>

<table><tbody><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;"><strong>Name</strong></td><td style="padding: 10px;"><strong>Value</strong></td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">type</td><td style="padding: 10px;">json</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">app</td><td style="padding: 10px;">quiz</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">response</td><td style="padding: 10px;">car</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">command</td><td style="padding: 10px;">guess</td></tr></tbody></table>

<table><tbody><tr><td><div class="td_head">nextQuestionNumber</div></td><td><div class="td_row_even">3</div></td></tr><tr><td><div class="td_head">questionsRemaining</div></td><td><div class="td_row_even">1</div></td></tr><tr><td><div class="td_head">nextQuestion</div></td><td><div class="td_row_even">bgo</div></td></tr><tr><td><div class="td_head">serverString</div></td><td><div class="td_row_even">correct</div></td></tr><tr><td><div class="td_head">guessResponse</div></td><td><div class="td_row_even">true</div></td></tr></tbody></table>


<div style="margin-top: 50px;">





<pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&response=obg&command=guess
{"nextQuestionNumber":4,"questionsRemaining":0,"nextQuestion":"cow","serverString":"wrong","guessResponse":"true"}
</pre>






</div>

<table><tbody><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;"><strong>Name</strong></td><td style="padding: 10px;"><strong>Value</strong></td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">type</td><td style="padding: 10px;">json</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">app</td><td style="padding: 10px;">quiz</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">response</td><td style="padding: 10px;">obg</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">command</td><td style="padding: 10px;">guess</td></tr></tbody></table>

<table><tbody><tr><td><div class="td_head">nextQuestionNumber</div></td><td><div class="td_row_even">4</div></td></tr><tr><td><div class="td_head">questionsRemaining</div></td><td><div class="td_row_even">0</div></td></tr><tr><td><div class="td_head">nextQuestion</div></td><td><div class="td_row_even">cow</div></td></tr><tr><td><div class="td_head">serverString</div></td><td><div class="td_row_even">wrong</div></td></tr><tr><td><div class="td_head">guessResponse</div></td><td><div class="td_row_even">true</div></td></tr></tbody></table>


<div style="margin-top: 50px;">





<pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&response=cow&command=guess
{"serverString": "correct", "programEnded": "true", "guessResponse" : "true"}
</pre>






</div>

<table><tbody><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;"><strong>Name</strong></td><td style="padding: 10px;"><strong>Value</strong></td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">type</td><td style="padding: 10px;">json</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">app</td><td style="padding: 10px;">quiz</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">response</td><td style="padding: 10px;">cow</td></tr><tr style="background-color: rgb(0, 43, 54);"><td style="padding: 10px;">command</td><td style="padding: 10px;">guess</td></tr></tbody></table>

<table><tbody><tr><td><div class="td_head">serverString</div></td><td><div class="td_row_even">correct</div></td></tr><tr><td><div class="td_head">programEnded</div></td><td><div class="td_row_even">true</div></td></tr><tr><td><div class="td_head">guessResponse</div></td><td><div class="td_row_even">true</div></td></tr></tbody></table>

</body>
</html>
