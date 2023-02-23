package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import frc.robot.huskylib.src.*;
import frc.robot.huskylib.src.WestCoastDriveTrain;
import frc.robot.huskylib.src.RoboDevice;

public class Simtest3Chassis extends RoboDevice{
    private WestCoastDriveTrain m_driveTrain = 
    new WestCoastDriveTrain(  WiringConnections.LEFT_MASTER_CONTROLLER_ID,
                              WiringConnections.LEFT_SLAVE_CONTROLLER_ID,
                              WiringConnections.RIGHT_MASTER_CONTROLLER_ID,
                              WiringConnections.RIGHT_SLAVE_CONTROLLER_ID
                           );
    
    
  private HuskyVector2D m_currentLocation;
  private double m_currentHeading = 0.0;
  private HuskyVector2D m_currentVelocity;
  private DifferentialDrivetrainSim m_drivetrainSim = new DifferentialDrivetrainSim(null, null, m_currentHeading, m_currentHeading, m_currentHeading, null);
  public Simtest3Chassis(){
    super("Simtest3Chassis");

    AddChildDevice(m_driveTrain);

    m_currentLocation = new HuskyVector2D();
    m_currentVelocity = new HuskyVector2D();
  }

  public void Initialize(){
    m_driveTrain.Initialize();
  }

  public void setTargForwardBack(double targFB){
    m_driveTrain.setTargSpeed(targFB);
  }

  public void setTargRotation(double targRot){
    m_driveTrain.setTargRotationSpeed(targRot);
  }

  @Override
  public void doGatherInfo() {
    super.doGatherInfo();

    m_currentVelocity.setVals(0.0, m_driveTrain.getCurrentSpeed());
    m_currentVelocity.rotate(m_currentHeading);

    m_currentLocation.addVec(m_currentVelocity);
  }

  public HuskyVector2D getCurrentLocation(){
    return m_currentLocation;
  }

  public HuskyVector2D getCurrentVelocity(){
    return m_currentVelocity;
  }

  public double getCurrentHeading(){
    return m_currentHeading;
  }


  @Override
  public void doActions() {
    super.doActions();
  }

}
