..\wc.exe -c test\test_cases\httpd.c -o test\test_output\out1.txt
..\wc.exe -w test\test_cases\httpd.c -o test\test_output\out2.txt
..\wc.exe -l test\test_cases\httpd.c -o test\test_output\out3.txt
..\wc.exe -a test\test_cases\httpd.c -o test\test_output\out4.txt
..\wc.exe -c -w -l test\test_cases\httpd.c -o test\test_output\out5.txt
..\wc.exe -e test\test_cases\stoptest.txt -c -w test\test_cases\test2.in -o test\test_output\out6.txt
..\wc.exe -w -c -l -s test\test_cases\*.in -o test\test_output\out7.txt
..\wc.exe -c test\test_cases\empty.c -o test\test_output\out8.out
..\wc.exe -c -l test\test_cases\*.in -a -s -w -o test\test_output\out9.txt
