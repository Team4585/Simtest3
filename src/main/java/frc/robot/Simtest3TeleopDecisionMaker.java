package frc.robot;

public class Simtest3TeleopDecisionMaker {
  private Simtest3Joystick m_TheJoystick = new Simtest3Joystick();

  private Simtest3Chassis m_Chassis;



  Simtest3TeleopDecisionMaker(){

  }

  public void initialize(){
  }

  public void doDecisions(){

    // System.out.println("-- F/B: " + m_TheJoystick.getForwardBackwardValue() + 
    //                    "   S/S: " + m_TheJoystick.getSideToSideValue() + 
    //                    "   Rot: " + m_TheJoystick.getTwistValue());

      m_Chassis.setTargForwardBack(m_TheJoystick.getForwardBackwardValue());
      m_Chassis.setTargRotation(m_TheJoystick.getTwistValue());


  }

  public void setChassis(Simtest3Chassis TheChassis){
    m_Chassis = TheChassis;
  }


}
