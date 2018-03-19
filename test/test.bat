..\wc.exe -c test\test_cases\httpd.c -o test\test_output\out1.out
..\wc.exe -w test\test_cases\httpd.c -o test\test_output\out2.out
..\wc.exe -l test\test_cases\httpd.c -o test\test_output\out3.out
..\wc.exe -a test\test_cases\httpd.c -o test\test_output\out4.out
..\wc.exe -c -w -l test\test_cases\httpd.c -o test\test_output\out5.out
..\wc.exe -e test\test_cases\stoptest.txt -c -w test\test_cases\test2.in -o test\test_output\out6.out
..\wc.exe -w -c -l -s test\test_cases\*.in -o test\test_output\out7.out
..\wc.exe -c test\test_cases\empty.c -o test\test_output\out8.out
..\wc.exe -c -l test\test_cases\*.in -a -s -w -o test\test_output\out9.out
