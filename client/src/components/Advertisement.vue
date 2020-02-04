<template>
    <v-container>
        <v-form
                ref="form"
                v-model="valid"
        >
            <v-layout
                    text-center
                    wrap
            >
                <v-flex xs12>
                    <v-img
                            :src="require('../assets/speaker-phone-1431953_960_720.png')"
                            class="my-3"
                            contain
                            height="200"
                    ></v-img>
                </v-flex>

                <v-container>
                    <div>
                        <p class="font-weight-black display-1">ADVERTISEMENT</p>
                    </div>

                </v-container>


                <v-container>
                    <v-row justify="center">
                        <v-col cols="12" sm="8">
                            <p>Sponsor</p>

                            <v-select
                                    v-model="advertisement.sponsorId"
                                    :items="sponsor"
                                    item-text="name"
                                    item-value="id"
                                    :rules="[v => !!v || 'Item is required']"
                                    label="-- ผู้สนับสนุน --"
                                    required
                            ></v-select>

                            <v-row justify="center">
                                <v-dialog v-model="dialog" persistent max-width="400px">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on"> Add Sponsor </v-btn>
                                    </template>
                                    <v-card>
                                        <v-card-title>
                                            <span class="headline">Sponsor' name</span>
                                        </v-card-title>
                                        <v-card-text>
                                            <v-container>
                                                <v-row>
                                                    <v-col cols="12" sm="6" md="10">
                                                        <v-text-field
                                                                label="Sponsor"
                                                                required
                                                                v-model="sponsor.name"
                                                        ></v-text-field>
                                                    </v-col>
                                                </v-row>
                                            </v-container>
                                        </v-card-text>
                                        <v-card-actions>

                                            <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
                                            <v-btn color="blue darken-1" text @click="saveSponsor">Save</v-btn>

                                        </v-card-actions>
                                    </v-card>
                                </v-dialog>
                            </v-row>

                        </v-col>
                    </v-row>

                </v-container>
                <v-container>
                    <v-row justify="center">
                        <v-col cols="12" sm="4">
                            <p>Type of advertisement</p>

                            <v-select
                                    v-model="advertisement.adtypeId"
                                    :items="adtype"
                                    item-text="name"
                                    item-value="id"
                                    :rules="[v => !!v || 'Item is required']"
                                    label="-- ประเภทของโฆษณา --"
                                    required
                            ></v-select>
                        </v-col>

                        <v-col cols="12" sm="4">
                            <p>Employee</p>

                            <v-select
                                    v-model="advertisement.employeeId"
                                    :items="employee"
                                    item-text="name"
                                    item-value="id"
                                    :rules="[v => !!v || 'Item is required']"
                                    label="-- พนักงาน --"
                                    required
                            ></v-select>
                        </v-col>
                    </v-row>
                </v-container>

                <v-container>
                    <v-row justify="center">
                        <v-col cols="12" sm="6" md="4">
                            <v-text-field
                                    v-model="advertisement.adLink"
                                    label="Advertisement address link"
                                    :rules="[v => !!v || 'Item is required']"
                                    required
                            ></v-text-field>
                        </v-col>

                        <v-col cols="12" sm="6" md="4">
                            <v-text-field
                                    v-model="advertisement.adTitle"
                                    label="Ad Title"
                                    :rules="[v => !!v || 'Item is required']"
                                    required
                            ></v-text-field>
                        </v-col>
                    </v-row>
                </v-container>

                <v-row justify="center">
                    <v-col cols="12">
                        <v-btn :disabled="!valid" color="success" @click="validate">Submit</v-btn>
                        <v-btn style="margin-left: 15px;" @click="clear">Reset</v-btn>
                    </v-col>
                </v-row>


            </v-layout>
        </v-form>
    </v-container>
</template>


<script>
import http from "../http-common";
/* eslint-disable */
export default {
  name: "advertisement",
  data() {
    return {
        advertisement: {
        sponsorId: [],
        employeeId: [],
        adtypeId: []
      },
      dialog: false,
      valid: false,
      sponsor : " ",
      adtype : " ",
      employee: " ",
      adLink: " ",
      adTitle: " ",
      name: " "
    };
  },

  methods: {
  /* eslint-disable no-console */

    // ดึงข้อมูล Employee ใส่ combobox
    getEmployees() {
      http
        .get("/employee")
        .then(response => {
          this.employee = response.data;
          console.log(response.employee);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Sponsor ใส่ combobox
    getSponsors() {
      http
        .get("/sponsor")
        .then(response => {
          this.sponsor = response.data;
          console.log(response.sponsor);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Adtype ใส่ combobox
    getAdtypes() {
      http
        .get("/adtype")
        .then(response => {
          this.adtype = response.data;
          console.log(response.adtype);
        })
        .catch(e => {
          console.log(e);
        });
    },

    // function เมื่อกดปุ่ม Summit
      validate() {
      http
        .post(
          "/advertisement/" +
            this.advertisement.adtypeId +
            "/" +
            this.advertisement.employeeId +
            "/" +
            this.advertisement.sponsorId +
            "/" +
            this.advertisement.adLink+
            "/" +
            this.advertisement.adTitle,
        this.advertisement
        )
        .then(response => {
          console.log(response);
          this.$router.push("/view");
          alert('บันทึกข้อมูลสำเร็จ');
          this.$refs.form.reset();
        })
        .catch(e => {
          console.log(e);
          alert('บันทึกข้อมูลไม่สำเร็จ');
        });
      this.submitted = true;

          //ถ้ากรอกทั้งหมดถึงจะขึ้นปุ่มให้กด
          if (this.$refs.form.validate()) {
              this.snackbar = true
          }
    },
    clear() {
      this.$refs.form.reset();
    },

      // function เมื่อกดปุ่ม Add sponsor
      saveSponsor() {
          http
              .post(
                  "/sponsor/" +
                  this.sponsor.name,
                  this.sponsor
              )
              .then(response => {
                  console.log(response);
                  this.$router.push("/view");
                  alert('บันทึกชื่อผู้สนับสนุนสำเร็จ');
                  this.$refs.form.reset();
                  this.getSponsors();
              })
              .catch(e => {
                  console.log(e);
                  alert('บันทึกชื่อผู้สนับสนุนไม่สำเร็จ');
              });
          this.submitted = true;
      }

    /* eslint-enable no-console */
  },

  mounted() {
      this.getEmployees();
      this.getSponsors();
      this.getAdtypes();
  }
};
</script>
