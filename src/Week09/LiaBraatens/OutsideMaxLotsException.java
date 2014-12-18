package Week09.LiaBraatens;

/**
 * 1011-071_Labs, Purpose: to show that a user is attempting to create a lot beyond the bounds of the max number of lots in a district
 * Class: SE 1011-071 Thomas    Lab: 9
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 11/12/2014 at 3:16 PM.
 */
public class OutsideMaxLotsException extends Exception
{
        /**
         * the constructor
         */
        public OutsideMaxLotsException()
        {
        }

        /**
         *
         * @return the message and te max number of lots that the district allows
         */
        @Override
        public String getLocalizedMessage()
        {
            return "a lot was added to a the District beyond its maximum number of lots " + District.MAX_LOTS;
        }

        /**
         *
         * @return getLocalizedMessage()
         */
        public String toString()
        {
            return this.getLocalizedMessage();
        }

}
