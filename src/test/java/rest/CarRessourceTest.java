//package rest;
//
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import entities.Car;
//import entities.Role;
//import entities.User;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.parsing.Parser;
//
//import io.restassured.response.Response;
//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.grizzly.http.util.HttpStatus;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.junit.jupiter.api.*;
//import utils.EMF_Creator;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.ws.rs.core.UriBuilder;
//import java.net.URI;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.request;
//
//
//class CarRessourceTest {
//
//    private static final int SERVER_PORT = 7777;
//    private static final String SERVER_URL = "http://localhost/api";
//    private static Car b1, b2;
//
//    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
//    private static HttpServer httpServer;
//    private static EntityManagerFactory emf;
//
//    private static String securityToken;
//    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
//
//    static HttpServer startServer() {
//        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
//        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
//
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//        EMF_Creator.startREST_TestWithDB();
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//
//        httpServer = startServer();
//
//        RestAssured.baseURI = SERVER_URL;
//        RestAssured.port = SERVER_PORT;
//        RestAssured.defaultParser = Parser.JSON;
//
//        setupUsers();
//
//
//    }
//
//    @AfterAll
//    public static void closeTestServer() {
//
//        EMF_Creator.endREST_TestWithDB();
//        httpServer.shutdownNow();
//
//    }
//
//    @BeforeEach
//    void setUp() {
//
//        EntityManager em = emf.createEntityManager();
//        b1 = new Car("tekst", "mere tekst", "endnu mere tekst");
//        b2 = new Car("tekst2", "mere tekst2", "endnu mere tekst2");
//        try {
//            em.getTransaction().begin();
//            em.createNamedQuery("Car.deleteAllRows").executeUpdate();
//            em.persist(b1);
//            em.persist(b2);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//
//
//    }
//
//
//
//
//
//
//    @Test
//    void getCarByRace() {
//    login("user", "test");
//    given()
//            .contentType(ContentType.JSON).header("x-access-token", securityToken)
//            .get("http://localhost:8080/SEM3EksamenBackend_war_exploded/api/car/getcarbyrace/PizzAround")
//            .then()
//            .assertThat()
//            .statusCode(HttpStatus.OK_200.getStatusCode());
//    }
//
//    @Test
//    void getAllRaces() {
//        Response response = RestAssured.get("http://localhost:8080/SEM3EksamenBackend_war_exploded/api/race/all");
//        System.out.println(response.getStatusCode());
//        System.out.println(response.asString());
//    }
//
//    @Test
//    void getDriverByRace() {
//        login("user", "test");
//        given()
//                .contentType(ContentType.JSON).header("x-access-token", securityToken)
//                .get("http://localhost:8080/SEM3EksamenBackend_war_exploded/api/driver/all")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.OK_200.getStatusCode());
//    }
//
//    private static void setupUsers() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            //Delete existing users and roles to get a "fresh" database
//            em.createQuery("delete from User").executeUpdate();
//            em.createQuery("delete from Role").executeUpdate();
//
//            Role userRole = new Role("user");
//            Role adminRole = new Role("admin");
//            User user = new User("user", "test");
//            user.addRole(userRole);
//            User admin = new User("admin", "test");
//            admin.addRole(adminRole);
//            User both = new User("user_admin", "test");
//            both.addRole(userRole);
//            both.addRole(adminRole);
//            em.persist(userRole);
//            em.persist(adminRole);
//            em.persist(user);
//            em.persist(admin);
//            em.persist(both);
//            //System.out.println("Saved test data to database");
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    private static void login(String role, String password) {
//        String json = String.format("{username: \"%s\", password: \"%s\"}", role, password);
//        securityToken = given()
//                .contentType("application/json")
//                .body(json)
//                //.when().post("/api/login")
//                .when().post("/login")
//                .then()
//                .extract().path("token");
//        //System.out.println("TOKEN ---> " + securityToken);
//    }
//
//}