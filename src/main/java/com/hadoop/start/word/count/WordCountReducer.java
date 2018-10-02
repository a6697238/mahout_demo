package com.hadoop.start.word.count;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * AUTO-GENERATED: houlu @ 2018/10/2 上午9:01
 *
 * @author houlu
 * @version 1.0.0
 * @since 1.0.0
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {


    @Override
    public void reduce(Text key, Iterable<IntWritable> values,
            Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }
        context.write(key, new IntWritable(sum));
    }


}
