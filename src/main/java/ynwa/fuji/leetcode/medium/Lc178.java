package ynwa.fuji.leetcode.medium;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-07.
 * https://discuss.leetcode.com/topic/16097/simple-short-fast
 * https://leetcode.com/problems/rank-scores/
 *
 * +-------+------+
 * | Score | Rank |
 * +-------+------+
 * | 4.00  | 1    |
 * | 4.00  | 1    |
 * | 3.85  | 2    |
 * | 3.65  | 3    |
 * | 3.65  | 3    |
 * | 3.50  | 4    |
 * +-------+------+
 */
public class Lc178 {
    /******************************************************************************
     mysql> explain select emp_no,@rank := @rank + (@prev <> (@prev := emp_no)) rank from salaries,(select @rank := 0,@prev := -1) init order by salary desc;
     +----+-------------+------------+--------+---------------+------+---------+------+---------+----------------+
     | id | select_type | table      | type   | possible_keys | key  | key_len | ref  | rows    | Extra          |
     +----+-------------+------------+--------+---------------+------+---------+------+---------+----------------+
     |  1 | PRIMARY     | <derived2> | system | NULL          | NULL | NULL    | NULL |       1 | Using filesort |
     |  1 | PRIMARY     | salaries   | ALL    | NULL          | NULL | NULL    | NULL | 2844513 |                |
     |  2 | DERIVED     | NULL       | NULL   | NULL          | NULL | NULL    | NULL |    NULL | No tables used |
     +----+-------------+------------+--------+---------------+------+---------+------+---------+----------------+
     3 rows in set (0.00 sec)
     ******************************************************************************/


    /******************************************************************************
     mysql> explain select emp_no, (select count(0) from (select distinct emp_no s from salaries ) as tmp where s >= emp_no) rank from salaries order by emp_no desc ;
     +----+--------------------+------------+-------+---------------+--------+---------+------+---------+--------------------------+
     | id | select_type        | table      | type  | possible_keys | key    | key_len | ref  | rows    | Extra                    |
     +----+--------------------+------------+-------+---------------+--------+---------+------+---------+--------------------------+
     |  1 | PRIMARY            | salaries   | index | NULL          | emp_no | 4       | NULL | 2844513 | Using index              |
     |  2 | DEPENDENT SUBQUERY | <derived3> | ALL   | NULL          | NULL   | NULL    | NULL |  300024 | Using where              |
     |  3 | DERIVED            | salaries   | range | NULL          | emp_no | 4       | NULL |  711129 | Using index for group-by |
     +----+--------------------+------------+-------+---------------+--------+---------+------+---------+--------------------------+
     3 rows in set (2.20 sec)
     ******************************************************************************/



    /******************************************************************************
     mysql> explain select s.emp_no,count(distinct t.emp_no) rank from salaries s join salaries t on s.emp_no<=t.emp_no group by s.id order by s.emp_no desc;
     ******************************************************************************/
     // 这个暂时不适用，因为没有主键id


    /******************************************************************************
     mysql> explain select emp_no, (select count(distinct emp_no) from salaries where emp_no >= s.emp_no) rank from salaries s order by s.emp_no desc ;
     +----+--------------------+----------+-------+----------------+--------+---------+------+---------+---------------------------------------+
     | id | select_type        | table    | type  | possible_keys  | key    | key_len | ref  | rows    | Extra                                 |
     +----+--------------------+----------+-------+----------------+--------+---------+------+---------+---------------------------------------+
     |  1 | PRIMARY            | s        | index | NULL           | emp_no | 4       | NULL | 2844513 | Using index                           |
     |  2 | DEPENDENT SUBQUERY | salaries | range | PRIMARY,emp_no | emp_no | 4       | NULL |  711129 | Using where; Using index for group-by |
     +----+--------------------+----------+-------+----------------+--------+---------+------+---------+---------------------------------------+
     2 rows in set (0.00 sec)
      ******************************************************************************/
//     这个看起来效率可能会好一些，但是执行的结果并不是预期的
//     +--------+------+
//     | emp_no | rank |
//     +--------+------+
//     | 499999 |    1 |
//     | 499999 |    0 |
//     | 499999 |    0 |
//     | 499999 |    0 |
//     | 499999 |    0 |
//     | 499998 |    0 |
//    发现个有趣的现象 http://stackoverflow.com/questions/38240629/why-rank-score-in-mysql-not-work-after-an-index-to-salary-of-table-salaries
/******************************************************************************
 mysql> select salary, (select count(distinct salary) from lc178 where salary >= s.salary) rank from lc178 s order by s.salary desc;
 +--------+------+
 | salary | rank |
 +--------+------+
 |  46950 |    1 |
 |  46950 |    1 |
 |  44789 |    2 |
 |  44789 |    2 |
 |  44500 |    3 |
 |  44500 |    3 |
 |  44500 |    3 |
 |  41797 |    4 |
 |  40000 |    5 |
 +--------+------+
 9 rows in set (0.00 sec)

 mysql> create index salary_lc178 on lc178(salary);
 Query OK, 0 rows affected (0.12 sec)
 Records: 0  Duplicates: 0  Warnings: 0

 mysql> select salary, (select count(distinct salary) from lc178 where salary >= s.salary) rank from lc178 s order by s.salary desc;
 +--------+------+
 | salary | rank |
 +--------+------+
 |  46950 |    1 |
 |  46950 |    0 |
 |  44789 |    0 |
 |  44789 |    0 |
 |  44500 |    0 |
 |  44500 |    0 |
 |  44500 |    0 |
 |  41797 |    0 |
 |  40000 |    0 |
 +--------+------+
 9 rows in set (0.00 sec)

 ******************************************************************************/


}
