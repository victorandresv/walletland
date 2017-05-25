package walletland.movitech.cl.walletland;

import android.provider.BaseColumns;

public class TblRegistersDefinition {
    public static abstract class Entry implements BaseColumns {
        public static final String TABLE_NAME ="tbl_registers";

        public static final String ID = "ID";
        public static final String NAME = "NAME";
        public static final String QUANTITY = "QUANTITY";
        public static final String OPTION = "OPTION";
        public static final String DATETIME = "DATETIME";
        public static final String PLACE = "PLACE";
    }
}
