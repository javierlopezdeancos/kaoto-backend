package io.kaoto.backend.model.deployment.kamelet.step;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.kaoto.backend.model.parameter.Parameter;
import io.kaoto.backend.model.step.Step;

import java.util.LinkedHashMap;
import java.util.Map;


public class LogStep extends EIPStep {
    public static final String MESSAGE = "message";
    public static final String MARKER = "marker";
    public static final String LOGGER = "logger";
    public static final String DESCRIPTION = "description";
    public static final String LOGGING_LEVEL = "logging-level";
    public static final String LOG_NAME = "log-name";
    public static final String LOGGING_LEVEL1 = "loggingLevel";
    public static final String LOG_NAME1 = "logName";

    private String message;

    @JsonProperty(LOGGING_LEVEL)
    private String loggingLevel;

    @JsonProperty(LOG_NAME)
    private String logName;
    private String marker;
    private String logger;
    private String description;

    public LogStep() {
    }

    public LogStep(Step step) {
        super(step);
    }

    @Override
    public Map<String, Object> getRepresenterProperties() {
        Map<String, Object> properties = new LinkedHashMap<>();
        if (this.message != null) {
            properties.put(MESSAGE, this.getMessage());
        }
        if (this.loggingLevel != null) {
            properties.put(LOGGING_LEVEL, this.getLoggingLevel());
        }
        if (this.logName != null) {
            properties.put(LOG_NAME, this.getLogName());
        }
        if (this.marker != null) {
            properties.put(MARKER, this.getMarker());
        }
        if (this.logger != null) {
            properties.put(LOGGER, this.getLogger());
        }
        if (this.description != null) {
            properties.put(DESCRIPTION, this.getDescription());
        }
        return properties;
    }


    @Override
    protected void assignAttribute(final Parameter parameter) {
        switch (parameter.getId()) {
            case MESSAGE:
                this.setMessage(parameter.getValue().toString());
                break;
            case LOGGING_LEVEL1:
            case LOGGING_LEVEL:
                this.setLoggingLevel(parameter.getValue().toString());
                break;
            case LOG_NAME1:
            case LOG_NAME:
                this.setLogName(parameter.getValue().toString());
                break;
            case MARKER:
                this.setMarker(parameter.getValue().toString());
                break;
            case LOGGER:
                this.setLogger(parameter.getValue().toString());
                break;
            case DESCRIPTION:
                this.setDescription(parameter.getValue().toString());
                break;
            default:
                log.error("Unknown property: " + parameter.getId());
                break;
        }
    }

    @Override
    protected void assignProperty(final Parameter parameter) {
        switch (parameter.getId()) {
            case MESSAGE:
                parameter.setValue(this.getMessage());
                break;
            case LOGGING_LEVEL1:
            case LOGGING_LEVEL:
                parameter.setValue(this.getLoggingLevel());
                break;
            case LOG_NAME1:
            case LOG_NAME:
                parameter.setValue(this.getLogName());
                break;
            case MARKER:
                parameter.setValue(this.getMarker());
                break;
            case LOGGER:
                parameter.setValue(this.getLogger());
                break;
            case DESCRIPTION:
                parameter.setValue(this.getDescription());
                break;
            default:
                log.error("Unknown property: " + parameter.getId());
                break;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(final String loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(final String logName) {
        this.logName = logName;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(final String marker) {
        this.marker = marker;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(final String logger) {
        this.logger = logger;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
