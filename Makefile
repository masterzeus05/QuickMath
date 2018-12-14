
all:
	javac App.java
	jar cfmv QuickMath.jar Manifest.txt *.class Games/*.class
	rm -r *.class */*.class

