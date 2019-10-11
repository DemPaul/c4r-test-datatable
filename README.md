# DataTable JavaSwing Application
> Test task from C4R

This is a simple application to create a datatable using the user interface 
and then write this data into a file for later reading and using this data in this app.  
The reflections library was used to create instances of all classes that implement 
the Field interface while the program runtime, and further work was performed 
using all created field classes. Therefore, to add a new field to the form and table 
it is enough to create a new class that implements the Field interface.  
JUnit tests added to test the validity of field validator methods.

<b>Performance description:</b>  
Clicking the "Add to table" button reads the data from the fields, validate them, 
and if validation completeed successfully, adds them to the table.  
The "Select file to save data" button is optional, it allows you to select or create a file, 
in which the data will be saved at the end of the program 
(to create a file in FileChooser you need to select a directory and write the name of a new file 
in the file selection field, after confirmation the file with the extension <b>.txt</b> 
will be created and selected as a file to save data).  
If file-to-save not selected at the time of exiting the program, the app will warn you 
and allow you to select or create this file. If you successfully select/create a file-to-save, 
the program will read data from this file the next time it starts.  
To launch the application run the <i><b>c4r-test-swing-datatable.jar</b></i> file.

<b>Technologies:</b>
- Java 7
- Java Swing
- Reflections
- JUnit
