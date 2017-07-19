from __future__ import print_function
import subprocess

def read_main():
    p = subprocess.Popen(["java", "Play"], stdout=subprocess.PIPE)
    line = p.stdout.readline()
    while(line != "x\n"):
        print(line, end='')
        line = p.stdout.readline()
def write_main():
    p = subprocess.Popen(["java", "Play"], stdin=subprocess.PIPE)
    p.stdin.write("First line\r\n")
    p.stdin.write("Second line\r\n")
    p.stdin.write("x\r\n") # this line will not be printed into the filek
if __name__ == '__main__': 
    write_main()
