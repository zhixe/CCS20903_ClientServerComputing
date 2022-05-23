#!/bin/bash 
# Make bash or shell script executable in the terminal
client="Client/Client";
server="Server/Server";

# PRE-RESET ALL
rm -rf Client/*.class Server/*.class

# Compiling the src codes
javac $client.java;
javac $server.java;

# Run the server
clear;
echo "Running the server...";
echo "Press CTRL + C to terminate the server!";

(trap 'kill 0' SIGINT; # Kill all the process within the subshell group
java $server; # Run the server, then run the client
rm -rf Client/*.class Server/*.class); # Reset all after running the app
echo "Program Successfully Terminated!";