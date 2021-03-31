package wayne.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Description: 各种路径取值
 * @author: LinWeiQi
 */
public class PathUtilsQ {

    final Logger log = LoggerFactory.getLogger(PathUtilsQ.class);

    public static void whereAmI() throws URISyntaxException {

        System.out.println("java.home : "+System.getProperty("java.home"));

        System.out.println("java.class.version : "+System.getProperty("java.class.version"));

        System.out.println("java.class.path : "+System.getProperty("java.class.path"));

        System.out.println("java.library.path : "+System.getProperty("java.library.path"));

        System.out.println("java.io.tmpdir : "+System.getProperty("java.io.tmpdir"));

        System.out.println("java.compiler : "+System.getProperty("java.compiler"));

        System.out.println("java.ext.dirs : "+System.getProperty("java.ext.dirs"));

        System.out.println("user.name : "+System.getProperty("user.name"));

        System.out.println("user.home : "+System.getProperty("user.home"));

        System.out.println("user.dir : "+System.getProperty("user.dir"));

        System.out.println("当前类所在包路径package: "+PathUtilsQ.class.getPackage().getName());

        String packName = PathUtilsQ.class.getPackage().getName();
        URI packuri = new URI(packName);
        System.out.println("当前类所在URI: "+packuri.getPath());

    }


}
