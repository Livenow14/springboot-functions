package com.livenow.jythonTest.hello;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class Test {

    @GetMapping("/python/test")
    public String test(){
        Properties props = new Properties();
        props.put("python.home","downloads file location"); //ex "C:\\Users\\Tj"
        props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
        props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
        props.put("python.import.site","false");

        Properties preprops = System.getProperties();

        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter intPre = new PythonInterpreter();

        intPre.execfile("python file location "); //ex "src/main/java/com/livenow/jythonTest/hello/Test.py"
        intPre.exec("print(testFunc(5,10))");

        PyFunction pyFunction = (PyFunction) intPre.get("testFunc",PyFunction.class);
        int a = 10, b=20;
        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println(pyobj.toString());

        return pyobj.toString();
    }
}
