#!/usr/bin/env bash
for((i=1;i<=100000000;i++));
do
ANS=`java codedrinker/ch03/PossibleReordering`
if [ $ANS != '(0,1)' ];then
    echo '第' $i '次运行 '$ANS
fi
done