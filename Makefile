make:
	javac -cp "src" -d "src" src/cool-files/Start.java src/cool-files/Boreee.java src/cool-files/j0el.java src/cool-files/ishy.java

run: make
	java -cp "src" Start
