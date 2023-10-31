package ex.vvs.et.rest;



import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")


@SwaggerDefinition(info = @Info(
        title = "Atlas Computer",
        description = "A simple example of apiee",
        version = "1.0.0",
        contact = @Contact(
                name = "hana tesfahun",
                email = "apiee@phillip-kruger.com",
                url = "http://phillip-kruger.com"
        )
)
)
public class RestApplication extends Application {
}