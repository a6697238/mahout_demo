package com.hadoop.start.word.count;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * AUTO-GENERATED: houlu @ 2018/10/2 上午9:03
 *
 * @author houlu
 * @version 1.0.0
 * @since 1.0.0
 */
public class WordCountJob {

    public static void main(String[] args)
            throws Exception {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "mywordCount");

        // 设置map操作
        job.setMapperClass(WordCountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 设置reduce操作
        job.setReducerClass(WordCountReducer.class);
        //这里reduce输入输出格式一致，不需要再次设置

        // 设置输入输出
        FileInputFormat
                .setInputPaths(job, new Path(
                        "/apps/GitWorkSpace/mahout_demo/datafile/LICENSE.txt"));
        FileOutputFormat.setOutputPath(job,
                new Path("/apps/GitWorkSpace/mahout_demo/word_count_result"));

        // 开始执行mapreduce作业
        job.waitForCompletion(true);

    }
}
