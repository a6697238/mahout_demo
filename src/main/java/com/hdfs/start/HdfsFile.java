package com.hdfs.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

/**
 * AUTO-GENERATED: houlu @ 2018/10/2 下午4:54
 *
 * @author houlu
 * @version 1.0.0
 * @since 1.0.0
 */
public class HdfsFile {

    public static void main(String[] args) throws Exception {
        mkdir();
//        listFiles();
    }


    /**
     * 上传文件到hdfs上
     */
    public static void upload() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://hzq:9000");
        FileSystem fs = FileSystem.get(conf);
        fs.copyFromLocalFile(new Path("/home/hzq/jdk1.8.tar.gz"), new Path("/demo"));
    }

    /**
     * 在hdfs更目录下面创建test1文件夹
     */
    public static void mkdir() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://127.0.0.1:9000");
        FileSystem fs = FileSystem.get(conf);
        fs.mkdirs(new Path("/user/houlu/input/test_dir"));
    }

    public static void listFiles() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://127.0.0.1:9000");
        FileSystem fs = FileSystem.newInstance(conf);
        // true 表示递归查找  false 不进行递归查找
        RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(new Path("/"), true);
        while (iterator.hasNext()){
            LocatedFileStatus next = iterator.next();
            System.out.println(next.getPath());
        }
        System.out.println("----------------------------------------------------------");
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (int i = 0; i < fileStatuses.length; i++) {
            FileStatus fileStatus = fileStatuses[i];
            System.out.println(fileStatus.getPath());
        }
    }



}
