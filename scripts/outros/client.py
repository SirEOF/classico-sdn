import socket   #for sockets
import sys  #for exit
 
# create dgram udp socket
try:
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
except socket.error:
    print 'Failed to create socket'
    sys.exit()
 
host = '192.168.2.1'
port = 10000;
videofile = "sample.mp4"

# try:
#     host = sys.argv[1]
#     port = int(sys.argv[2])
#     videofile = sys.argv[3]
# except:
    # print "[Usage: cliente.py host port videofile]\n"
    # host = '192.168.2.1';
    # port = 10000;
    # videofile = "sample.mp4"


s.sendto(videofile, (host, port))


data = 100

while(data > 0) :

    try :
        d = s.recvfrom(1024)

        data = int(d[0])
        addr = d[1]
        # size_data -= len(data);
        print(data)


        # HexFile.write(data)
    except socket.error, msg:
        print 'Error Code : ' + str(msg[0]) + ' Message ' + msg[1]
        # HexFile.close()
        sys.exit()