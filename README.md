<p>Using a web browser, the user visits a site with the intention of completing a flashcard quiz.  (Currently localhost).</p>

<p>The user presses a button to start a quiz.  This begins the prompting of quiz questions. Pressing Enter or the Submit button causes the server to evaluate the question through JSON/Ajax. </p> 

<p>The server runs a program that simulates a quiz, it has no data storage, and all data is hardcoded.  This release doesn't evaluate the questions and answers correctly, it just fakes it, and produces a hardwired correct/incorrect response.</p>

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


<div style="margin-top: 0px;">

<br><pre>
http://localhost:8080/Flashcardquiz-java/
</pre>
<br>

</div>

  <table border="3">
  </table>

<br>
<div style="margin-top: 0px;">

<br><pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&command=start
</pre>
<br>

</div>

  <table border="3">
    <tr><td>type</td><td>json</td></tr>
    <tr><td>app</td><td>quiz</td></tr>
    <tr><td>command</td><td>start</td></tr>
  </table>

<br>
<div style="margin-top: 0px;">

<br><pre>
{"nextQuestionNumber":1,"questionsRemaining":3,"nextQuestion":"aqt","serverString":"Welcome!","guessResponse":""}

</pre>

</div>
<table border="1">  <tr>
    <td>nextQuestionNumber</td><td>1</td>
  </tr>
  <tr>
    <td>questionsRemaining</td><td>3</td>
  </tr>
  <tr>
    <td>nextQuestion</td><td>aqt</td>
  </tr>
  <tr>
    <td>serverString</td><td>Welcome!</td>
  </tr>
  <tr>
    <td>guessResponse</td><td></td>
  </tr>
</table>

<br><br><hr>
<br><hr>
<div style="margin-top: 0px;">

<br><pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=taq
</pre>
<br>

</div>

  <table border="3">
    <tr><td>type</td><td>json</td></tr>
    <tr><td>app</td><td>quiz</td></tr>
    <tr><td>userResponse</td><td>taq</td></tr>
  </table>

<br>
<div style="margin-top: 0px;">

<br><pre>
{"nextQuestionNumber":2,"questionsRemaining":2,"nextQuestion":"acr","serverString":"","guessResponse":"wrong"}

</pre>

</div>
<table border="1">  <tr>
    <td>nextQuestionNumber</td><td>2</td>
  </tr>
  <tr>
    <td>questionsRemaining</td><td>2</td>
  </tr>
  <tr>
    <td>nextQuestion</td><td>acr</td>
  </tr>
  <tr>
    <td>serverString</td><td></td>
  </tr>
  <tr>
    <td>guessResponse</td><td>wrong</td>
  </tr>
</table>

<br><br><hr>
<br><hr>
<div style="margin-top: 0px;">

<br><pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=car
</pre>
<br>

</div>

  <table border="3">
    <tr><td>type</td><td>json</td></tr>
    <tr><td>app</td><td>quiz</td></tr>
    <tr><td>userResponse</td><td>car</td></tr>
  </table>

<br>
<div style="margin-top: 0px;">

<br><pre>
{"nextQuestionNumber":3,"questionsRemaining":1,"nextQuestion":"bgo","serverString":"","guessResponse":"correct"}

</pre>

</div>
<table border="1">  <tr>
    <td>nextQuestionNumber</td><td>3</td>
  </tr>
  <tr>
    <td>questionsRemaining</td><td>1</td>
  </tr>
  <tr>
    <td>nextQuestion</td><td>bgo</td>
  </tr>
  <tr>
    <td>serverString</td><td></td>
  </tr>
  <tr>
    <td>guessResponse</td><td>correct</td>
  </tr>
</table>

<br><br><hr>
<br><hr>
<div style="margin-top: 0px;">

<br><pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=obg
</pre>
<br>

</div>

  <table border="3">
    <tr><td>type</td><td>json</td></tr>
    <tr><td>app</td><td>quiz</td></tr>
    <tr><td>userResponse</td><td>obg</td></tr>
  </table>

<br>
<div style="margin-top: 0px;">

<br><pre>
{"nextQuestionNumber":4,"questionsRemaining":0,"nextQuestion":"cow","serverString":"","guessResponse":"wrong"}

</pre>

</div>
<table border="1">  <tr>
    <td>nextQuestionNumber</td><td>4</td>
  </tr>
  <tr>
    <td>questionsRemaining</td><td>0</td>
  </tr>
  <tr>
    <td>nextQuestion</td><td>cow</td>
  </tr>
  <tr>
    <td>serverString</td><td></td>
  </tr>
  <tr>
    <td>guessResponse</td><td>wrong</td>
  </tr>
</table>

<br><br><hr>
<br><hr>
<div style="margin-top: 0px;">

<br><pre>
http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=cow
</pre>
<br>

</div>

  <table border="3">
    <tr><td>type</td><td>json</td></tr>
    <tr><td>app</td><td>quiz</td></tr>
    <tr><td>userResponse</td><td>cow</td></tr>
  </table>

<br>
<div style="margin-top: 0px;">

<br><pre>
{"guessResponse": "correct", "programEnded": "true"}

</pre>

</div>
<table border="1">  <tr>
    <td>guessResponse</td><td>correct</td>
  </tr>
  <tr>
    <td>programEnded</td><td>true</td>
  </tr>
</table>

<br><br><hr>
<br><hr>
