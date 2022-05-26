package se1ex12.src;

/*
 * University of Aizu [Introduction to Software Engineering] Exercise material
 *
 * Class: ProcurementControl
 *
 * Date: 
 *
 * author: 
 *
 */
/*
 *
 * Complete the implementation of this class "ProcurementControl"
 *
 */
import java.sql.SQLException;
import java.util.Date;

public class ProcurementControl {
  // Declare necessary variables
  private Procurement procurement;
  private DBAccess dbAccess;

  public ProcurementControl() throws ClassNotFoundException, SQLException {
    // Initialization of DBAccess
    dbAccess = new DBAccess();
  }

  // Declare and implement necessary methods
  public ProcurementStaff getStaff(String staffCode){
    ProcurementStaff ps = new ProcurementStaff(staffCode, dbAccess);
    boolean status = ps.checkStaff();
    if(!status)
      ps = null;
    return ps;
  }

  public Material getMaterial(String materialCode){
    Material material = new Material(materialCode, dbAccess);
    boolean status = material.checkMaterial();
    if(!status)
      material = null;
    return material;
  }

  public Procurement getProcurement(String procurementId){
    Procurement procurement = new Procurement(procurementId, dbAccess);
    boolean status = procurement.checkProcurement();
    if(!status)
      procurement = null;
    return procurement;
  }

  public boolean recordProcurement(String procurementId, String staffCode, String materialCode,Integer amount, Date requestedDate){
    Procurement procurement = new Procurement(procurementId, staffCode, materialCode, amount, requestedDate, dbAccess);
    return procurement.addProcurement();
  }
}
