

let myheader = `<p>Using a web browser, the user visits a site with the intention of completing a flashcard quiz.  (Currently localhost).</p>

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

`

console.log(myheader)



let path="localhost.har"

 
let fs = require('fs')
let myhar = fs.readFileSync(path, "utf8")



let myobj = JSON.parse(myhar)

let s = ''
let rx = ''

for (let entry of myobj.log.entries) {
  console.log('<div style="margin-top: 0px;">')
  console.log('\n<br><pre>')
  console.log(entry.request.url)
  console.log('</pre>\n<br>\n')
  console.log('</div>')
  let qs = entry.request.queryString
  if (qs) {
    s = ''
    s += '\n  <table border="3">\n'
    for(let qspart of qs) {
      if (qspart.name) {
        s += '    <tr><td>' + qspart.name + '</td><td>' + qspart.value + '</td></tr>\n'
      }
    }
    s += '  </table>\n\n<br>'
    console.log(s)
  }
  // text is just unparsed json as text
  let rxtext = entry.response.content.text
  if (rxtext.charAt(0) == '{') {
     console.log('<div style="margin-top: 0px;">')
     console.log('\n<br><pre>')
     console.log(entry.response.content.text)
     console.log('</pre>\n')
     console.log('</div>')
     let myobj2 = JSON.parse(rxtext)
     rx = '<table border="1">'
     for(mykey of Object.keys(myobj2)) {
       rx += '  <tr>\n'
       rx += '    <td>' + mykey + '</td><td>' + myobj2[mykey] + '</td>\n'
       rx += '  </tr>\n'
     }
     rx += '</table>\n\n<br><br><hr>\n<br><hr>'
     console.log(rx)
  }
}

