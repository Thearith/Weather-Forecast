package thearith.github.com.weatherforecast.view.model;

/**
 * Enum class that represents API response status
 */
public enum Status {

    /**
     * Idle State
     * */
    IDLE,

    /**
     * Progress State
     * */
    IN_PROGRESS,

    /**
     * Complete State with results
     * */
    COMPLETE,

    /**
     * Error State (ex: Connection error, Error 403, etc)
     * */
    ERROR
}
