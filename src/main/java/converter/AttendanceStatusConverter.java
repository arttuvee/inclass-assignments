package converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AttendanceStatusConverter implements AttributeConverter<AttendanceStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AttendanceStatus status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public AttendanceStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return AttendanceStatus.fromValue(dbData);
    }
}