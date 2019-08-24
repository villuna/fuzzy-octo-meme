make:
	javac -cp "src" -d "src" src/cool-files/Start.java 

run: make
	java -cp "src" Start
