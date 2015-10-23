/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import deploy.DeploymentConfiguration;
import entity.Cars;
import facade.CarFacade;
import infrastructure.ICarFacade;
import java.io.IOException;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rest.JSONConverter.JSONConverter;

/**
 * REST Web Service
 *
 * @author RolfMoikjær
 */
@Path("car")
public class CarResource {

    @Context
    private UriInfo context;

    private ICarFacade facade;
    private Gson gson;
    
    public CarResource() {
        this(new CarFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME)));
    }
    
    public CarResource(ICarFacade carFacade) {
        this.facade = carFacade;
        gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete")
    public Response getCars() throws IOException {
        List<Cars> c = facade.getCars();

        return Response.ok(JSONConverter.CarToJSON(c)).build();
    }

}
