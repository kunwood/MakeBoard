import React from "react";
import Navigation from "../../Navigation";
import { Box } from "@mui/material";
import Authentication from "../../Authentication";

export default function MainLayout() {
  return (
    <div>
      <>
        <Navigation />
        <Authentication />
      </>
    </div>
  );
}
