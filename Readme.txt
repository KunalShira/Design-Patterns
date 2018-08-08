
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf kunal_shira_assign_2.tar.gz kunal_shira_assign_2

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/03/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
BST :
Average Case
insert - O(log n)
search - O(log n)
delete - O(log n)

Worst Case
insert - O(n)
search - O(n)
delete - O(n)

-----------------------------------------------------------------------

Provide justification for how your observer subject pattern works

I added 2 variables to store observers in the node class to make updates to that particular node which is replica of the original node.
So when inserting a node to an original tree I am cloning two more nodes and then setting observer node to those two variables of original node.
Whenever a certain node is being deleted I am making call to notifyall method which simply notifies the nodes which are observer of node i.e. course to be deleted.
Notifyall method then calls the update method with the parameters. Those parameters are the observers of node cources I am going to delete.
Values of course from the original tree node are copied to linked observer nodes.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
stackoverflow.com/questions//17203493
https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
