#!/bin/bash
#
# Client
rm files/rd01 
ufw enable
tcpdump -i any -n -tt -v udp port 12345 > files/rd01 