#!/bin/bash
#
# Server
rm files/sd$1
ufw enable
tcpdump -n -tt -v udp port 12345 >  files/sd$1