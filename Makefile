# Compiler and flags
JAVAC = javac
JAVA = java
# Use appropriate remove command based on OS
ifeq ($(OS),Windows_NT)
    RM = del /Q
else
    RM = rm -f
endif

# Find all Java files in the current directory
SRC = $(wildcard *.java)
# Specify the main class (with package)
MAIN = Java15.Main

# Default rule to compile all Java files
all: $(SRC)
	$(JAVAC) $(SRC)

# Run the main class
run: all
	$(JAVA) -classpath .. $(MAIN)

# Clean up compiled classes
clean:
	$(RM) *.class
