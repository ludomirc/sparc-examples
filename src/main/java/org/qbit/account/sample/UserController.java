package org.qbit.account.sample;


import spark.ExceptionHandler;

import static org.qbit.account.JsonUtil.json;
import static spark.Spark.*;

public class UserController {
        public UserController(final UserService userService) {
                get("/users", (req, res) -> userService.getAllUsers(), json());


                after((req, res) -> {
                        res.type("application/json");
                });

                exception(Exception.class, exceptionHandler());

             /*   exception(IllegalArgumentException.class, (e, req, res) -> {
                        res.status(400);
                        res.body(toJson(new ResponseError(e)));
                });*/

        }

        private ExceptionHandler exceptionHandler() {
                return (e, req, res) -> {
                        res.status(500);
                        res.body("<h1>Exception occurred</h1><div>" + e.getMessage() + "</div>");
                };
        }
}