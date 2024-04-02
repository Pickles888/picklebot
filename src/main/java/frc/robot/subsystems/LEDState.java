package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

public class LEDState{

    BooleanSupplier m_isActive;
    int[] m_color;

    public LEDState(BooleanSupplier isActive, int[] color) {
        m_isActive = isActive;
        m_color = color;
    }

    public Boolean isActive(){
        return m_isActive.getAsBoolean();
    }
}