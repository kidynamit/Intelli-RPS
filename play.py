from __future__ import print_function
import subprocess

def read_main():
    p = subprocess.Popen(["java", "Play"], stdout=subprocess.PIPE)
    line = p.stdout.readline()
    while(line != "x\n"):
        print(line, end='')
        line = p.stdout.readline()
def write_main():
    p = subprocess.Popen(["java", "Play"], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    line, err= p.communicate(input='RRR\nPPP\n'.encode())
    print(line.decode())

if __name__ == '__main__': 
    write_main()
