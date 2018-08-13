State Design Pattern


Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=0

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf kunal_shira_assign_3.tar.gz kunal_shira_assign_3

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/19/2017]

-----------------------------------------------------------------------
Provide justification for how your state pattern works
where ever new line of input i.e. traveller comes process it inside helper class's tightenOrLossen() method. 
tightenOrLossen() method forwards decision to driver class which state is going to come the next. Passing that to the context class. 
Initially current state is set to low_risk in context class. Whenever decision is made it is forwarded to context class and the from there 
delegated to particular class. If the state is new it is forwarded to current class next link and then setted new state as current state.
Then current states own method gets invoked and tostring method returns those ids of that state to driver to copy result into result string.
This is how my state Pattern is implemented. Calculations are done in helper class.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
