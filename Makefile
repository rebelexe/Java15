# Compiler and flags
JAVAC = javac
JAVA = java
RM = rm -f

# Find all Java files in the current directory
SRC = $(wildcard *.java)
# Specify the main class (with package)
MAIN = -classpath .. Java15.Main

# Default rule to compile all Java files
all: $(SRC)
	$(JAVAC) $(SRC)

# Run the main class
run: all
	$(JAVA) $(MAIN)

# Clean up compiled classes
clean:
	$(RM) *.class
