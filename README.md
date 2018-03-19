# WordCounter

一个简单的Java统计字符程序

# Requirement

JRE 1.7+

# Usage

```l
wc.exe [-c|-w|-l|-a|-s] [filename] [-o [outputfile]] [-e [escapeWordList]]
```

| option | description                        |                         |
| ------ | ---------------------------------- | ----------------------- |
| -c     | 统计字符数                         |                         |
| -w     | 统计单词书                         |                         |
| -l     | 统计行数                           |                         |
| -a     | 统计代码行/空行/注释行             |                         |
| -s     | 递归统计文件夹下所有符合条件的文件 | 如 *.c *.in             |
| -o     | 指定输出文件                       |                         |
| -e     | 统计字符时忽略该文件列表中的词     | 以空格，制表符，',‘分隔 |

其中参数c、w、l、a、s与filename的顺序任意

## Example



```
wc.exe -w -l -a test\test_cases\test3.in -c -o output.out
```

```
wc.exe -c -s -w -a test\test_cases\*.in -e eacape_word.txt
```

# PSP(Personal Software Process)

| PSP2.1                                  | PSP阶段                                 | 预估耗时实际耗时（分钟） | 实际耗时（分钟） |
| --------------------------------------- | --------------------------------------- | ------------------------ | ---------------- |
| Planning                                | 计划                                    | 15                       | 23               |
| Estimate                                | 估计这个任务需要多少时间                | 10                       | 10               |
| Development                             | 开发                                    | 530                      | 892              |
| - Analysis                              | - 需求分析（包括学习新技术）            | 100                      | 339              |
| - Design Spec                           | - 生成设计文档                          | 100                      | 150              |
| - Coding Standard                       | - 代码规范 (为目前的开发制定合适的规范) | 10                       | 8                |
| - Design                                | - 具体设计                              | 30                       | 23               |
| - Coding                                | - 具体编码                              | 200                      | 220              |
| - Code Review                           | - 代码复审                              | 30                       | 34               |
| - Test                                  | - 测试（自我测试，修改代码，提交修改）  | 60                       | 120              |
| Reporting                               | 报告                                    | 190                      | 309              |
| - Test Report                           | - 测试报告                              | 60                       | 65               |
| - Size Measurement                      | - 计算工作量                            | 10                       | 12               |
| - Postmortem & Process Improvement Plan | -  事后总结, 并提出过程改进计划         | 120                      | 232              |
|                                         | 合计                                    | 745                      | 1234             |