/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import entity.Cars;
import java.util.List;

/**
 *
 * @author RolfMoikjær
 */
public interface ICarFacade {
    List<Cars> getCars();
}
