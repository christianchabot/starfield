production=Main.java Display.java Stars3D.java
junit=DisplayTest.java

lib=org.junit.runner.JUnitCore
CPATH=${CLASSPATH}:~/java/junit-4.13-beta-3.jar:~/java/hamcrest-core-1.3.jar

all:
	javac ${production}

run: all
	java Main

test: all
	echo ${CPATH}
	cp ${junit} ~/java
	env CLASSPATH=${CPATH} javac ${junit}
	env CLASSPATH=${CPATH} java ${lib} ${junit:.java=}

clean:
	rm *.class
	rm ~/java/${junit}
