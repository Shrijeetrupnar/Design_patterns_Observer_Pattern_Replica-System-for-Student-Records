# CSX42: Assignment 3
## Name: Shrijeet Rupnar
## B-00808280

-------------------------------------------------------------------------

Due Date:  July 10, 2020 
Submitted date : July 10, 2020 
Author(s): Shrijeet Rupnar 
e-mail(s): srupnar1@binghamton.edu

PERCENT COMPLETE: I believe I have completed 100% of this project.

BUGS: No bugs.



---------------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [studentskills/src](./studentskills/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile studentskills/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile studentskills/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile studentskills/src/build.xml run -Dinput="input.txt" -Dmodify="modify.txt" -Dout1="output1.txt" -Dout2="output2.txt" -Dout3="output3.txt" -Derror="error.txt" -Ddebug="2"
```
Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------------------------------------
## Description:

Replica System for Student Records :


-----------------------------------------------------------------------------------------------------
Provide justification for Data Structures used in this assignment in term of Big O complexity (time and/or space):

I have decided to use Binary search Tree as my data structure for below reasons:
1. For searching a Node in a tree , BST has O(n) worst case Time complexity
2. For Insertion of a node in a tree,BST has O(n) worst case Time complexity

------------------------------------------------------------------------------------------------------------

## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [07/10/2020]

citation:

http://tutorials.jenkov.com/java-collections/map.html
http://www.newthinktank.com/2013/03/binary-tree-in-java/



